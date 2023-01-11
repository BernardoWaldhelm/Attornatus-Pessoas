package br.com.pessoa.http.control;

import br.com.pessoa.entity.Address;
import br.com.pessoa.service.AddresService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa/{id}/endereco")
public class AdrressController {

    @Autowired
    private AddresService addresService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address salvar(@RequestBody Address address) { return addresService.salvar(address);}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Address> listaAddress() { return addresService.listaAdrress();}
}
