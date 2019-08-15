package com.carrillo.invoiceplatform.invoiceplatform.entrypoint.rest;

import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.User;
import com.carrillo.invoiceplatform.invoiceplatform.domain.usecases.GetUserUseCase;
import com.carrillo.invoiceplatform.invoiceplatform.domain.usecases.ReportUseCase;
import com.carrillo.invoiceplatform.invoiceplatform.domain.usecases.SaveUserUseCase;
import com.carrillo.invoiceplatform.invoiceplatform.entrypoint.dto.ReportDTO;
import com.carrillo.invoiceplatform.invoiceplatform.entrypoint.dto.UserDTO;
import com.carrillo.invoiceplatform.invoiceplatform.util.Mapper;
import com.carrillo.invoiceplatform.invoiceplatform.util.MessageContextItem;
import com.carrillo.invoiceplatform.invoiceplatform.util.constants.PathConstants;
import com.carrillo.invoiceplatform.invoiceplatform.util.constants.ResponseConstants;
import context.EnumMessageContext;
import context.MessageContext;
import exceptions.MessageContextException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathConstants.USER)
@RequiredArgsConstructor
public class UserController {

    private final SaveUserUseCase saveUserUseCase;

    private final GetUserUseCase getUserUseCase;

    private final Mapper<UserDTO, User> userDTOUserMapper;

    private final Mapper<User, UserDTO> userUserDTOMapper;

    MessageContext messageContext = new EnumMessageContext<>(MessageContextItem.class);

    @PostMapping(PathConstants.SAVE)
    private ResponseEntity<String> reportUser(@RequestBody UserDTO user) throws MessageContextException {

        messageContext.addItem(MessageContextItem.USER, userDTOUserMapper.map(user));
        saveUserUseCase.handle(messageContext);
        return new ResponseEntity<>(ResponseConstants.SAVEDSUCCESSFULLY,
                HttpStatus.OK);

    }

    @GetMapping
    private ResponseEntity<UserDTO> reportUser(@RequestParam String uuid) throws MessageContextException {

        messageContext.addItem(MessageContextItem.UUID, uuid);
        getUserUseCase.handle(messageContext);
        return new ResponseEntity<>(userUserDTOMapper.map((User) messageContext.getitem(MessageContextItem.USER,
                User.class)),HttpStatus.OK);

    }
}
