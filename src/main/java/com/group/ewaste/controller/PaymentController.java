package com.group.ewaste.controller;


import javax.servlet.http.HttpServletRequest;

import com.group.ewaste.config.RuoYiConfig;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.File;
import com.group.ewaste.mapper.FileMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.group.ewaste.config.PaypalPaymentIntent;
import com.group.ewaste.config.PaypalPaymentMethod;
import com.group.ewaste.service.PaypalService;
import com.group.ewaste.util.URLUtils;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.web.bind.annotation.ResponseBody;

@Api("/pay")
@Controller
@RequestMapping("/pay")
public class  PaymentController {

    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;
    @Autowired
    private FileMapper fileMapper;

    @ApiOperation(value = "", notes = "", httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam("username")String username,@RequestParam("fileId")String fileId,HttpServletRequest request){
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL+"?username="+username+"&fileId="+fileId;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL+"?username="+username+"&fileId="+fileId;
        try {
            Payment payment = paypalService.createPayment(
                    10.00,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    System.out.println("links.getHref()-->"+links.getHref());
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "HttpServletRequest", name = "request", value = "", required = true)
    })
    @ApiOperation(value = "", notes = "", httpMethod = "POST")
    @RequestMapping(method = RequestMethod.POST, value = "pay")
    public String pay(HttpServletRequest request){
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
        try {
            Payment payment = paypalService.createPayment(
                    10.00,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    System.out.println("links.getHref()-->"+links.getHref());
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

    @ApiOperation(value = "", notes = "", httpMethod = "GET")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/cancel")
    public AjaxResult cancelPay(){
        return AjaxResult.success("cancel");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "paymentId", value = "", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "payerId", value = "", required = true)
    })
    @ApiOperation(value = "", notes = "", httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET, value ="/success")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,@RequestParam("username")String username,@RequestParam("fileId")Long fileId) throws PayPalRESTException {
        System.out.println("username==>"+username);
        System.out.println("fileId==>"+fileId);
//        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
//                return AjaxResult.success("支付成功");
                File file=new File();
                file.setId(fileId);
                file.setIsPay(1);
                fileMapper.updateById(file);
                return "redirect:" +   RuoYiConfig.getFronturl()+"/#/pages/payStatus/success?username="+username;
            }
//        } catch (PayPalRESTException e) {
//            log.error(e.getMessage());
//            return"redirect:" + "http://localhost:8081/#/pages/payStatus/fail?username="+username;
//        }
        return"redirect:" + RuoYiConfig.getFronturl()+ "/#/pages/payStatus/fail?username="+username;
    }

}

