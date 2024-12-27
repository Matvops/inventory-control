package com.cadenassi.inventory_control.dto.mappers;


import com.cadenassi.inventory_control.dto.objects.purchase.PurchaseDTO;
import com.cadenassi.inventory_control.model.transactions.purchase.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    PurchaseMapper INSTANCE = Mappers.getMapper(PurchaseMapper.class);

    PurchaseDTO toPurchaseDTO(Purchase purchase);

    Purchase toPurchase(PurchaseDTO purchaseDTO);

    List<PurchaseDTO> toListPurchaseDTO(List<Purchase> purchases);

    List<Purchase> toListPurchase(List<PurchaseDTO> purchaseDTOs);
}
