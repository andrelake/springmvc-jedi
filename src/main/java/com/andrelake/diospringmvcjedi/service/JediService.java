package com.andrelake.diospringmvcjedi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrelake.diospringmvcjedi.exception.JediNotFoundException;
import com.andrelake.diospringmvcjedi.model.Jedi;
import com.andrelake.diospringmvcjedi.repository.JediRepository;

@Service
public class JediService {

	@Autowired
	private JediRepository repository;
	
	public List<Jedi> findAll() {

        return repository.findAll();
   }

   public Jedi findById(final Long id) {
       final Optional<Jedi> jedi = repository.findById(id);

       if(jedi.isPresent()){
           return jedi.get();
       }else{
           throw new JediNotFoundException();
       }
   }

   public Jedi save(final Jedi jedi) {
       return repository.save(jedi);
   }

   public Jedi update(final Long id, final Jedi jedi) {
       final Optional<Jedi> jediEntity = repository.findById(id);
       final Jedi jedi2;

       if (jediEntity.isPresent()) {
           jedi2 = jediEntity.get();
       }else {
           throw new JediNotFoundException();
       }

       jedi2.setName(jedi.getName());
       jedi2.setLastName(jedi.getLastName());

       return repository.save(jedi2);
   }

   public void delete(final Long id) {
       final Jedi jedi = findById(id);

       repository.delete(jedi);
   }
}
