package com.projeto.automoveis.repository;

import com.projeto.automoveis.models.CarrosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<CarrosModel, Long> {
}
