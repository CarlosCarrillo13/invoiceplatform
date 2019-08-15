package com.carrillo.invoiceplatform.invoiceplatform.domain.usecases;

import UseCases.UseCase;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pipeline.Pipeline;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportUseCase implements UseCase {

    private final Pipeline reportPipeline;

    @Override
    public void handle(MessageContext messageContext) {

        try {
            reportPipeline.execute(messageContext);
        } catch (MessageContextException e) {

            log.error(e.getCause().getMessage());
            e.printStackTrace();
        }
    }
}
