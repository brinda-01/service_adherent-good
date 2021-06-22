package com.example.service_adherent.service.adherent;

import com.example.service_adherent.graph_domain.nodes.Adherent;
import com.example.service_adherent.graph_domain.nodes.Arbre;
import com.example.service_adherent.graph_domain.nodes.Noeud;
import com.example.service_adherent.graph_domain.nodes_repositories.AdherentRepository;
import com.example.service_adherent.graph_domain.nodes_repositories.NoeudRepository;
import com.example.service_adherent.mapper.Dtos.AdherentDto;
import com.example.service_adherent.mapper.MapStructMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdherentServiceImpl implements AdherentService{
    private final NoeudRepository noeudRepository;
    private final MapStructMapper mapper;
    private final AdherentRepository adherentRepository;

    @Override
    public void addAdherent(AdherentDto adherentDto) {

        Noeud noeud = noeudRepository.findByIdNoeud(adherentDto.getIdNoeud());

        noeud.setAdherent(adherentRepository.
                                    save(mapper.
                                            adherentDtoToAdherent(adherentDto)
                                    )
        );

        noeudRepository.save(noeud);



    }

    @Override
    public Adherent searchAdherent(String compte) {
        if (compte.isEmpty()){
            return null;
        }
        return adherentRepository.findByCompte(compte);
        //return null;
    }

    @Override
    public Page<Adherent> pagesAdherent(Map<String, String> filter, int numPage, int taille) {


        List<Sort.Order>  orders = new ArrayList<>();
        for(Map.Entry<String,String> entry :  filter.entrySet())
            orders.add(new Sort.Order(Sort.Direction.valueOf(entry.getValue()) ,entry.getKey()));
        PageRequest  pageable = PageRequest.of(numPage,taille, Sort.by(orders));
        //Page<Adherent> produAdherents =adherentRepository.findAll(pageable);
        return adherentRepository.findAll(pageable);
//        return produAdherents;
    }

    @Override
    public Adherent updateAdherent(Adherent adherent) {
        return adherentRepository.save(adherent);
    }
}
