package com.cadenassi.inventory_control.services.transaction;

import com.cadenassi.inventory_control.dto.mappers.ProductMapper;
import com.cadenassi.inventory_control.dto.mappers.PurchaseMapper;
import com.cadenassi.inventory_control.dto.objects.product.ProductDTO;
import com.cadenassi.inventory_control.dto.objects.purchase.PurchaseDTO;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import com.cadenassi.inventory_control.repositories.ProductRepository;
import com.cadenassi.inventory_control.repositories.transaction.PurchaseRepository;
import com.cadenassi.inventory_control.services.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{


    private static final Logger log = LoggerFactory.getLogger(PurchaseServiceImpl.class);

    @Autowired
    private PurchaseMapper mapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<PurchaseDTO> getAll() {
        var purchases = mapper.toListPurchaseDTO(purchaseRepository.findAll());

        return purchases;
    }

    @Override
    public PurchaseDTO getPurchaseById(String id) {
        var purchase = mapper.toPurchaseDTO(purchaseRepository
                .findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("PURCHASE NOT FOUND!")));

        return purchase;
    }

    @Transactional
    @Override
    public List<PurchaseDTO> getPurchaseByDate(String date) {
        var purchases = mapper.toListPurchaseDTO(purchaseRepository.getPurchaseByDate(date));

        return purchases;
    }

    @Transactional
    @Override
    public List<PurchaseDTO> getPurchaseByTimeRange(String first, String last) {
        var purchases = mapper.toListPurchaseDTO(purchaseRepository.getPurchaseByTimeRange(first, last));

        return purchases;
    }


    @Override
    public PurchaseDTO insertPurchase(PurchaseDTO purchaseDTO) {

        purchaseDTO.total();

        var dto = mapper.toPurchaseDTO(purchaseRepository.save(mapper.toPurchase(purchaseDTO)));

        return dto;
    }

    @Override
    public PurchaseDTO addQuantityProduct() {
        return null;
    }

    @Override
    public PurchaseDTO updateDescription(String description) {
        return null;
    }
}
