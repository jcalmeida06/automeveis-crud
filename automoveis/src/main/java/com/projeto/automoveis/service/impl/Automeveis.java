package com.projeto.automoveis.service.impl;

import com.projeto.automoveis.models.CarrosModel;
import com.projeto.automoveis.repository.CarrosRepository;
import com.projeto.automoveis.service.AutomoveisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Automeveis implements AutomoveisService {

    @Autowired
    private CarrosRepository carrosRepository;

    @Override
    public CarrosModel salvar(CarrosModel carro) {
        return carrosRepository.save(carro);
    }

    @Override
    public CarrosModel atualizar(Long id, CarrosModel carro) {
        if (carrosRepository.existsById(id)) {
            carro.setId(id);
            return carrosRepository.save(carro);
        } else {
            throw new RuntimeException("Carro não encontrado com o id " + id);
        }
    }

    @Override
    public void deletar(Long id) {
        carrosRepository.deleteById(id);
    }

    @Override
    public Optional<CarrosModel> buscarPorId(Long id) {
        return carrosRepository.findById(id);
    }

    @Override
    public List<CarrosModel> listarTodos() {
        return carrosRepository.findAll();
    }
}