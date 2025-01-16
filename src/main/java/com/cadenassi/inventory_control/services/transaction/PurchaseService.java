package com.cadenassi.inventory_control.services.transaction;



import com.cadenassi.inventory_control.dto.objects.purchase.PurchaseDTO;

import java.util.List;

public interface PurchaseService {

    List<PurchaseDTO> getAll();

    PurchaseDTO getPurchaseById(String id);

    List<PurchaseDTO> getPurchaseByDate(String date);

    List<PurchaseDTO> getPurchaseByTimeRange(String first, String last);

    PurchaseDTO insertPurchase(PurchaseDTO purchaseDTO);

    PurchaseDTO updateDescription(String description);
}
