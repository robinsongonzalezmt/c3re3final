/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.servicio;

import co.edu.usa.modelo.Box;
import co.edu.usa.repositorio.BoxRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cala0
 */

@Service
public class BoxServicio {
@Autowired

private BoxRepository boxRepository;
    
   public List<Box> getAll() {
   return (List<Box>) boxRepository.getAll();};
  
  public Optional<Box> getBox(int id) {return boxRepository.getBox(id);};
  
  public Box save(Box box) { 
       if (box.getId()== null){
           return boxRepository.save(box);
       }
       else
       {
          Optional<Box> co =  boxRepository.getBox(box.getId());
          if (co.isEmpty()){
              return boxRepository.save(box);
          }
          else
          {
              return box;
          }
       }
 
    }

  
    //////// RETO 4 
  
//public Box update(Box box){
//        if(box.getBoxId()!=null){
//            Optional<Box> e= boxRepository.getBox(box.getBoxId());
//            if(!e.isEmpty()){
//
//                if(box.getStartDate()!=null){
//                    e.get().setStartDate(box.getStartDate());
//                }
//                if(box.getDevolutionDate()!=null){
//                    e.get().setDevolutionDate(box.getDevolutionDate());
//                }
//                if(box.getStatus()!=null){
//                    e.get().setStatus(box.getStatus());
//                }
//                boxRepository.save(e.get());
//                return e.get();
//            }else{
//                return box;
//            }
//        }else{
//            return box;
//        }
//    }

 public boolean deleteBox(int boxId){
        Boolean d=getBox(boxId).map(box -> {
            boxRepository.delete(box);
            return true;
        }).orElse(false);
        return d;
    }
   
}
     

