package ru.geekbrains.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.services.CategoriesService;
import ru.geekbrains.soap.categories.GetCategoriesByTitleRequest;
import ru.geekbrains.soap.categories.GetCategoriesByTitleResponse;

@Endpoint
@RequiredArgsConstructor
public class CategoriesEndpoint {
    private static final String NAMESPACE_URI = "http://www.geekbrains.ru/categories";
    private final CategoriesService categoriesService;


//    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.geekbrains.ru/categories">
//    <soapenv:Header/>
//        <soapenv:Body>
//            <f:getCategoriesByTitleRequest>
//                <f:title>Food</f:title>
//            </f:getCategoriesByTitleRequest>
//        </soapenv:Body>
//    </soapenv:Envelope>

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoriesByTitleRequest")
    @ResponsePayload
    @Transactional
    public GetCategoriesByTitleResponse getCategoryByTitle(@RequestPayload GetCategoriesByTitleRequest request){
        GetCategoriesByTitleResponse response = new GetCategoriesByTitleResponse();
        response.setCategory(categoriesService.getByTitle(request.getTitle()));
        return response;
    }
}