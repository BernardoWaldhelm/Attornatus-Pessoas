package br.com.pessoa.service;

import br.com.pessoa.entity.Address;
import br.com.pessoa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddresService {

    @Autowired
    private AddressRepository addressRepository;

    public Address salvar(Address address) {return addressRepository.save(address);}

    public List<Address> listaAdrress() { return addressRepository.findAll(); }
}
