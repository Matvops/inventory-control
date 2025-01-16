package com.cadenassi.inventory_control.controllers.transaction;

import com.cadenassi.inventory_control.dto.objects.purchase.PurchaseDTO;
import com.cadenassi.inventory_control.model.transactions.purchase.Purchase;
import com.cadenassi.inventory_control.proxy.transaction.PurchaseProxy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/purchase/v1")
@Tag(name = "Purchases", description = "Purchase controller")
public class PurchaseController {

    @Autowired
    private PurchaseProxy proxy;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Get all purchases", description = "Get all purchases",
            tags = {"Purchases"}, responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , array = @ArraySchema(schema = @Schema(implementation = PurchaseDTO.class)))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content)
    })
    public ResponseEntity<List<PurchaseDTO>> getAll() {
        return ResponseEntity.ok().body(proxy.getAll());
    }

    @GetMapping(value = "/date", params = {"day", "month", "year"}
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PurchaseDTO>> getPurchaseByDate(@PathParam(value = "day") String day,
                                                               @PathParam(value = "month") String month,
                                                               @PathParam(value = "year") String year){
        var date = String.format("%s/%s/%s", day, month, year);

        return ResponseEntity.ok().body(proxy.getPurchaseByDate(date));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Insert a new purchase", description = "insert a new purchase with new products",
            tags = {"Purchases"}, responses = {
            @ApiResponse(responseCode = "201", description = "SUCCESS"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , schema = @Schema(implementation = PurchaseDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content)
    })
    public ResponseEntity<PurchaseDTO> insertPurchase(@RequestBody PurchaseDTO purchaseDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(proxy.insertPurchase(purchaseDTO));
    }
}
