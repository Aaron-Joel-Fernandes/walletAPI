package com.edureka.wallet.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edureka.wallet.api.WalletService;
import com.edureka.wallet.model.PaymentTransactionDto;
import com.edureka.wallet.model.WalletDto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

	private static final Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);
	private final Map<String, WalletDto> walletMap = new HashMap<>();

	@Override
	public WalletDto doTransaction(PaymentTransactionDto transaction) {
		logger.info("Transaction request received = {} ", transaction);
		// Implemented
		return transaction.getWalletDto();
	}

	@Override
	public WalletDto getBalance(String emailId,WalletDto wallet) {
		logger.info("Get Wallet balance request received = {} ", emailId);
		// Implemented
		PaymentTransactionDto transaction= new PaymentTransactionDto();
		transaction.setEmailId(emailId);
		transaction.setWalletDto(wallet);
		return transaction.getWalletDto();
	}

	@Override
	public WalletDto addWallet(WalletDto walletDto) {
		walletDto.setWalletId(UUID.randomUUID().toString());
		walletMap.put(walletDto.getWalletId(), walletDto);
		return walletDto;
	}

	@Override
	public WalletDto updateWallet(String id, WalletDto walletDto) {
		WalletDto wallet = walletMap.get(id);
		if (wallet != null) {
			wallet.setBalance(walletDto.getBalance());
			walletMap.put(id, wallet);
			return wallet;
		}
		return null;
	}

}
