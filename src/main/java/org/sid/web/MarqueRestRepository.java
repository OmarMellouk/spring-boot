package org.sid.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.sid.dao.MarqueRepository;
import org.sid.entities.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MarqueRestRepository {

	@Autowired
	private MarqueRepository marqueRepository ;
	
	 @GetMapping("/marques")
	    public List<Marque> getAllMarques() {
	        return marqueRepository.findAll();
	    }
	 
	 @GetMapping("/chercherMarques")
		public List<Marque> chercher(@RequestParam( name="name", defaultValue="") String name ){
			return marqueRepository.findByNameLike("%"+name+"%");
		}
	
	 @GetMapping("/marques/{id}")
	    public Marque getMarqueById(@PathVariable(value = "id") Long marqueId)
	    {
	        return marqueRepository.findById(marqueId).orElse(null);
	         
	    }
	 
	 @PostMapping("/marques")
	    public Marque createMarque(@Valid @RequestBody Marque marque) {
	        return marqueRepository.save(marque);
	    }
		
		
		@DeleteMapping("/marques/{id}")
	    public Map<String, Boolean> deleteMarque(@PathVariable(value = "id") Long marqueId)
	         {
	        Marque marque = marqueRepository.findById(marqueId).orElse(null); 
	        marqueRepository.delete(marque);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
		
		
		@PutMapping("/marques/{id}")
	    public Marque updateMarque(@PathVariable(value = "id") Long marqueId,
	         @Valid @RequestBody Marque marqueDetails){
	        Marque marque = marqueRepository.findById(marqueId).orElse(null);
	        

	        marque.setId(marqueDetails.getId());
	        marque.setName(marqueDetails.getName());
	        marque.setMrqimg(marqueDetails.getMrqimg());
	        final Marque updatedMarque = marqueRepository.save(marque);
	        return marqueRepository.save(updatedMarque);
	    }
		
}
