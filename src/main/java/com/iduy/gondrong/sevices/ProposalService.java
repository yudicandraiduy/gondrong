package com.iduy.gondrong.sevices;

import com.iduy.gondrong.models.Proposal;
import com.iduy.gondrong.payload.request.ProposalRequest;
import com.iduy.gondrong.repository.ProposalRepository;
import com.iduy.gondrong.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {

    private final ProposalRepository repository;

    private final UserRepository userRepository;

    public ProposalService(ProposalRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public Proposal addData (ProposalRequest request){
        Proposal proposal = new Proposal();
        proposal.setLatarBelakang(request.getLatarBelakang());
        proposal.setNamaKegiatan(request.getNamaKegiatan());
        proposal.setMaksudKegiatan(request.getMaksudKegiatan());
        proposal.setTujuanKegiatan(request.getTujuanKegiatan());
        proposal.setKriteriaSponsorship(request.getKriteriaSponsorship());
        proposal.setPenutup(request.getPenutup());
        proposal.setWaktuAwal(request.getWaktuAwal());
        proposal.setWaktuAkhir(request.getWaktuAkhir());
        proposal.setTempatKegiatan(request.getTempatKegiatan());
        proposal.setBentukKegitan(request.getBentukKegitan());
        proposal.setSusunanKegiatan(request.getSusunanKegiatan());
        proposal.setEstimasiBiaya(request.getEstimasiBiaya());
        userRepository.findById(request.getUserId()).ifPresent(proposal::setUser);
        return repository.save(proposal);
    }
}
