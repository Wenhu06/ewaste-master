package com.group.ewaste.mapper;

import com.group.ewaste.domain.Product;
import com.group.ewaste.domain.ProductExample;

import java.util.List;

public class ProductMapperImpl implements ProductMapper {

    private final ProductMapper productMapper;

    public ProductMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    @Override
    public long countByExample(ProductExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(ProductExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Product record) {
        return 0;
    }

    @Override
    public int insertSelective(Product record) {
        return 0;
    }

    @Override
    public List<Product> selectByExample(ProductExample example) {
        return null;
    }

    @Override
    public Product selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Product record, ProductExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Product record, ProductExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return 0;
    }
    public Double getPriceByName(String name) {
        return productMapper.getPriceByName(name);
    }

}
