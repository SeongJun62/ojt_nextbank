package com.ojtbank.api.service;

import com.ojtbank.common.dto.TransferDto;

public interface TransferService {
    void transfer(TransferDto transferDto);
}
