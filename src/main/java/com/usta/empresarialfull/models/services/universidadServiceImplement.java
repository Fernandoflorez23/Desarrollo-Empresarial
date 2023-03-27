package com.usta.empresarialfull.models.services;

import com.usta.empresarialfull.entities.universidadEntity;
import com.usta.empresarialfull.models.dao.universidadDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class universidadServiceImplement implements IuniversidadService{
    @Autowired
    private universidadDAO universidadDAO;

    /**
     * @Desc este método es la implementación del dao - FinAll CrudRepository
     *      1. @Transactional metodo con peticion a BD
     *      2. Retornar todos los registros de la BD
     * @CreateAt 01-03-2023
     * @Version 0.0.0
     * @Author Fernando Florez Caballero
     * @Required Interfaz del servicio
     */

    @Override
    @Transactional(readOnly=true)
    public List<universidadEntity> findAll() {
        return (List<universidadEntity>) universidadDAO.findAll();
    }

    /**
     * @Desc Este método es la implementación del dao - save CrudRepository
     *      1. @Transactional método con petición a BD
     *      2. Realiza INSERT en BD
     * @CreateAll 01-03-2023
     * @Version 0.0.1
     * @Author Fernando Florez
     * @Required Interfaz servicio
     */

    @Override
    @Transactional
    public void save(universidadEntity universidad){
        universidadDAO.save(universidad);
    }

    /**
     * @Desc Este método es la implementación del dao - delete CrudRepository
     *      1. @Transactional método con petición a BD
     *      2. Realiza delete en BD pasando como párametro el id del registro
     * @CreateAll 01-03-2023
     * @Version 0.0.1
     * @Author Fernando Florez
     * @Required Interfaz service
     */

    @Override
    @Transactional
    public void remove(Long id) {
        universidadDAO.deleteById(id);
    }

    /**
     * @Desc Este método es la implementación del dao - update CrudRepository
     *      1. @Transactional método con petición a BD
     *      2. Realiza update en BD pasando como párametro el id del registro
     * @CreateAll 01-03-2023
     * @Version 0.0.1
     * @Author Fernando Florez
     * @Required Interfaz servicio
     */

    @Override
    @Transactional
    public universidadEntity updateUniversidad(universidadEntity universidad){
        return universidadDAO.save(universidad);
    }
}
