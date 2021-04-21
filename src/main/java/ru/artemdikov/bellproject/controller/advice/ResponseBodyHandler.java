package ru.artemdikov.bellproject.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.artemdikov.bellproject.controller.advice.dto.DataDto;
import ru.artemdikov.bellproject.controller.advice.dto.ErrorDto;
import ru.artemdikov.bellproject.controller.advice.dto.SuccessDto;

/**
 * Сработать после выполнения методов контроллеров, но до записи ответа
 * и вносит изменения в объект ответа
 */
@RestControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o == null) {
            o = new SuccessDto();
        } else if (o.getClass() != ErrorDto.class) {
            DataDto dataDto = new DataDto();
            dataDto.setData(o);
            o = dataDto;
        }
        return o;
    }
}
