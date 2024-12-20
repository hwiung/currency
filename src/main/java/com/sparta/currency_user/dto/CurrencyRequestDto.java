package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter

public class CurrencyRequestDto {
    @NotNull(message = "currencyName 값은 필수입니다11999999")
    private String currencyName;
    @NotNull(message = "exchangeRate 값은 필수입니다")
    private BigDecimal exchangeRate;
    @NotNull(message = "symbol 값은 필수입니다")
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }

    public Currency toEntity1() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
    public Currency toEntity11() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
    public Currency toEntity2() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
    public Currency toEntity3() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
}

