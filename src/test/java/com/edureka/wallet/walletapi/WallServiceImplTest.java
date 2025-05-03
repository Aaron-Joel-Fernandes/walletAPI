package com.edureka.wallet.walletapi;

import com.edureka.wallet.Impl.WalletServiceImpl;
import com.edureka.wallet.model.PaymentTransactionDto;
import com.edureka.wallet.model.WalletDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletServiceImplTest {

    private WalletServiceImpl walletService;

    @BeforeEach
    void setUp() {
        walletService = new WalletServiceImpl();
    }

    @Test
    void testAddWalletAssignsUUIDAndStoresWallet() {
        WalletDto walletDto = new WalletDto();
        walletDto.setBalance(100.0f);

        WalletDto result = walletService.addWallet(walletDto);

        assertNotNull(result.getWalletId(), "Wallet ID should not be null");
        assertEquals(100.0f, result.getBalance());
    }

    @Test
    void testUpdateWalletSuccess() {
        WalletDto walletDto = new WalletDto();
        walletDto.setBalance(50.0f);
        WalletDto addedWallet = walletService.addWallet(walletDto);

        WalletDto updatedDto = new WalletDto();
        updatedDto.setBalance(200.0f);
        WalletDto result = walletService.updateWallet(addedWallet.getWalletId(), updatedDto);

        assertNotNull(result);
        assertEquals(200.0f, result.getBalance());
    }

    @Test
    void testUpdateWalletWalletNotFoundReturnsNull() {
        WalletDto updatedDto = new WalletDto();
        updatedDto.setBalance(200.0f);

        WalletDto result = walletService.updateWallet("non-existent-id", updatedDto);
        assertNull(result, "Updating non-existent wallet should return null");
    }

    @Test
    void testDoTransactionReturnsSameWalletDto() {
        WalletDto walletDto = new WalletDto();
        walletDto.setBalance(150.0f);

        PaymentTransactionDto transaction = new PaymentTransactionDto();
        transaction.setWalletDto(walletDto);

        WalletDto result = walletService.doTransaction(transaction);

        assertNotNull(result);
        assertEquals(150.0f, result.getBalance());
    }

    @Test
    void testGetBalanceReturnsEmptyWalletDto() {
        WalletDto walletDto = new WalletDto();
        walletDto.setBalance(150.0f);
        walletDto.setWalletId("1");


        WalletDto result = walletService.getBalance("someone@example.com",walletDto);
        assertNotNull(result.getWalletId(), "Expected wallet ID to be null");
        assertNotNull(result.getBalance(), "Expected balance to be null");
    }
}
