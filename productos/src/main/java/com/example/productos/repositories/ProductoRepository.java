package com.example.productos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commons.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
