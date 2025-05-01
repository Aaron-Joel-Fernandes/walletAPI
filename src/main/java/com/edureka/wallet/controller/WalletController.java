package com.edureka.wallet.controller;


import com.edureka.wallet.api.WalletService;
import com.edureka.wallet.model.WalletDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
    @Autowired
    WalletService walletService;
    @PostMapping("/wallet")
    public ResponseEntity<WalletDto> createWallet(@RequestBody WalletDto walletDto) {
        return new ResponseEntity<>(walletService.addWallet(walletDto), HttpStatus.CREATED);
    }

    @PutMapping("/wallet/{id}")
    public ResponseEntity<WalletDto> updateWallet(@PathVariable String id, @RequestBody WalletDto walletDto) {
        WalletDto updated = walletService.updateWallet(id, walletDto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}
