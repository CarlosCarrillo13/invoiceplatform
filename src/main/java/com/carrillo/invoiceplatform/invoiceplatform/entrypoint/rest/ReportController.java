package com.carrillo.invoiceplatform.invoiceplatform.entrypoint.rest;

import com.carrillo.invoiceplatform.invoiceplatform.domain.usecases.ReportUseCase;
import com.carrillo.invoiceplatform.invoiceplatform.entrypoint.dto.ReportDTO;
import com.carrillo.invoiceplatform.invoiceplatform.util.MessageContextItem;
import com.carrillo.invoiceplatform.invoiceplatform.util.constants.PathConstants;
import context.EnumMessageContext;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(PathConstants.REPORT)
@RequiredArgsConstructor
public class ReportController {

    private final ReportUseCase reportUseCase;

    MessageContext messageContext = new EnumMessageContext<>(MessageContextItem.class);

    @PostMapping(PathConstants.USER)
    private ResponseEntity<ReportDTO> reportUser(@RequestParam String UUID) throws MessageContextException {

        messageContext.addItem(MessageContextItem.UUID, UUID);
        reportUseCase.handle(messageContext);

        //TODO map from domain to report
        return new ResponseEntity<>((ReportDTO) messageContext.getitem(MessageContextItem.REPORT, ReportDTO.class),
                HttpStatus.OK);

    }
}
