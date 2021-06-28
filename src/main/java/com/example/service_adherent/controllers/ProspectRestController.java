package com.example.service_adherent.controllers;

import com.example.service_adherent.mapper.Dtos.ProspectEmailInvitationDto;
import com.example.service_adherent.service.Prospect.ProspectService;
import com.example.service_adherent.service.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activate")
public class ProspectRestController {

    private final ProspectService adherentService;
    private final TokenService tokenService;

    @PostMapping("/mail-invitation")
    public ResponseEntity mailInvitation (@RequestBody ProspectEmailInvitationDto invitationDto){

        adherentService.parrainerViaMail(invitationDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/verification")
    public RedirectView tokenVerification(@RequestParam("sign") String sign){
        RedirectView redirectView = new RedirectView();

        if( tokenService.findToken(sign).getValable() == false){

            redirectView.setUrl("https://www.bing.com/");
        }
        redirectView.setUrl("https://www.google.com/search?q="+tokenService.findToken(sign).getUser().getIdNoeud());

        return redirectView;
    }
}
