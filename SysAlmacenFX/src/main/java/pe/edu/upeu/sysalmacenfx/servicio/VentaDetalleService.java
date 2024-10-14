package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaDetalleService {

    @Autowired
    CategoriaRepository repo;

    //C
    public VentaDetalleService save(VentaDetalleService to){
    return repo.save(to);
    }

    //R
    public List<VentaDetalleService> list(){
        return repo.findAll();
    }
    //U
    public VentaDetalleService update(VentaDetalleService to, Long id){
        try {
            VentaDetalleService toe=repo.findById(id).get();
            if(toe!=null){
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }

    public VentaDetalleService update(Categoria to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public VentaDetalleService searchById(Long id){
        return repo.findById(id).get();
    }


    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(VentaDetalleService cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdVentaDetalleService()));
            cb.setValue(cate.getNombre());
            listar.add(cb);
        }
        return listar;
    }


}
