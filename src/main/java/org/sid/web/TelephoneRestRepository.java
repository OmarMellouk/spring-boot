package org.sid.web;

import java.util.List;

import javax.validation.Valid;

import org.sid.dao.MarqueRepository;
import org.sid.dao.TelephoneRepository;
import org.sid.entities.Telephone;
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
public class TelephoneRestRepository {

	@Autowired
	  private TelephoneRepository assignmentRepository;
	  
	  @Autowired
	  private MarqueRepository studentRepository;
	  
	    @GetMapping("/marques/{marqueId}/telephones")
	    public List<Telephone> getContactByStudentId(@PathVariable Long marqueId) {
	      
//	        if(!studentRepository.existsById(studentId)) {
//	            throw new NotFoundException("Student not found!");
//	        }
	      
	      return assignmentRepository.findByMarqueId(marqueId);
	    }
	    
	    @GetMapping("/marques/{marqueId}/telephones/chercherTelephone")
		public List<Telephone> chercher(@RequestParam( name="name", defaultValue="") String name ,
				@PathVariable Long marqueId){
			return assignmentRepository.findByNameLike("%"+name+"%",marqueId);
		}
	    
	    @GetMapping("/chercherTelephone")
		public List<Telephone> chercherTelephone(@RequestParam( name="name", defaultValue="") String name ){
			return assignmentRepository.findByNameLike2("%"+name+"%");
		}
	    
	    @PostMapping("/marques/{marqueId}/telephones")
	    public Telephone addAssignment(@PathVariable Long marqueId,
	                            @Valid @RequestBody Telephone assignment) {
	        return studentRepository.findById(marqueId)
	                .map(student -> {
	                    assignment.setMarque(student);
	                    return assignmentRepository.save(assignment);
	                }).orElse(null);
	    }
	    
	    @PutMapping("/marques/{marqueId}/telephones/{telephoneId}")
	    public Telephone updateAssignment(@PathVariable Long marqueId,
	                    @PathVariable Long telephoneId,
	                    @Valid @RequestBody Telephone assignmentUpdated) {
	      
//	      if(!studentRepository.existsById(studentId)) {
//	        throw new NotFoundException("Student not found!");
//	      }
	      
	        return assignmentRepository.findById(telephoneId)
	                .map(assignment -> {
	                    assignment.setName(assignmentUpdated.getName());
	                    assignment.setTelimg(assignmentUpdated.getTelimg());
	                    return assignmentRepository.save(assignment);
	                }).orElse(null);
	    }
	    
	    @DeleteMapping("/marques/{marqueId}/telephones/{telephoneId}")
	    public String deleteAssignment(@PathVariable Long marqueId,
	                     @PathVariable Long telephoneId) {
	      
//	      if(!studentRepository.existsById(studentId)) {
//	        throw new NotFoundException("Student not found!");
//	      }
	      
	        return assignmentRepository.findById(telephoneId)
	                .map(assignment -> {
	                    assignmentRepository.delete(assignment);
	                    return "Deleted Successfully!";
	                }).orElse(null);
	    }
}
