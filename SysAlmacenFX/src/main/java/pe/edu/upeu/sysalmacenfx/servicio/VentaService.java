package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    CategoriaRepository repo;

    //C
    public VentaService save(VentaService to){
    return repo.save(to);
    }

    //R
    public List<VentaService> list(){
        return repo.findAll();
    }
    //U
    public VentaService update(VentaService to, Long id){
        try {
            VentaService toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }

    public VentaService update(VentaService to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public VentaService searchById(Long id){
        return repo.findById(id).get();
    }


    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(VentaService cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdVentaService()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }


}
