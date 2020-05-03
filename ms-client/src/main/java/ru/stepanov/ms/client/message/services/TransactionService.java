package ru.stepanov.ms.client.message.services;

import ru.stepanov.ms.client.common.services.BaseMicroservice;
import ru.stepanov.ms.client.message.models.transacitons.MessageListRequest;
import ru.stepanov.ms.client.message.models.transacitons.MessageListResponse;
import ru.stepanov.ms.client.message.models.transacitons.MessageSendRequest;
import ru.stepanov.ms.client.message.models.transacitons.MessageSendResponse;
import ru.stepanov.ms.client.message.interfaces.ITransactioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class TransactionService extends BaseMicroservice implements ITransactioService {

    @Autowired
    public TransactionService(RestTemplate restTemplate){
        super("ms-messages", restTemplate);
    }

    @Override
    public MessageSendResponse send(MessageSendRequest request) throws Exception {
        return retry(()-> restTemplate.postForEntity(buildUrl(MESSAGES_SERVICE_SEND_V1), request, MessageSendResponse.class).getBody());
    }

    @Override
    public MessageListResponse list(MessageListRequest request) throws Exception {
        return retry(()-> restTemplate.postForEntity(buildUrl(MESSAGES_SERVICE_LIST_V1), request, MessageListResponse.class).getBody());
    }
}
