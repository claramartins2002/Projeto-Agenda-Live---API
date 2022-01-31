package com.estudosAngular.API.Lives.service;

import com.estudosAngular.API.Lives.entity.Lives;
import com.estudosAngular.API.Lives.repository.LiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class LiveServices {
    @Autowired
    LiveRepository liveRepository;

    public Page<Lives> findAll(Pageable pageable, String flag) {
        if(flag !=null && flag.equals("today")) {
            return liveRepository.findLivesToday( pageable);
        }
        else if(flag != null && flag.equals("next")){
            return liveRepository.findLivesNext( pageable);
        }
        else if(flag != null && flag.equals("previous")){
            return liveRepository.findLivesPrevious( pageable);
        }

        else {
            return liveRepository.findAll(pageable);
        }
    }

    public Lives findById(String id) {Optional<Lives> optional= liveRepository.findById(Long.valueOf(id));
        return optional.orElseThrow(() -> new EntityNotFoundException("Live inexistente"));
    }

    public Lives save (Lives live) { return  liveRepository.save(live);}

    public ResponseEntity<Lives> delete (Lives live) { liveRepository.delete(live);
        return null;
    }
    public Lives edit (Lives live, String id) { Lives instancia = this.findById(id);
        return liveRepository.save(live);}
}
