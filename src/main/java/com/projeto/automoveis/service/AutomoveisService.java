package com.projeto.automoveis.service;

import com.projeto.automoveis.models.CarrosModel;
import java.util.List;
import java.util.Optional;

public interface AutomoveisService {
    CarrosModel salvar(CarrosModel carro);
    CarrosModel atualizar(Long id, CarrosModel carro);
    void deletar(Long id);
    Optional<CarrosModel> buscarPorId(Long id);
    List<CarrosModel> listarTodos();
}