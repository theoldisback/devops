package tn.esprit.tpfoyer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.service.FoyerServiceImpl;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;






@ExtendWith(MockitoExtension.class)
class FoyerServicelmplTest {

    @Mock
    FoyerRepository foyerRepository;

    @InjectMocks
    FoyerServiceImpl foyerService;

    @Test
    void retrieveFoyerTest() {
        Foyer foyer = new Foyer();
        when(foyerRepository.findById(foyer.getIdFoyer())).thenReturn(Optional.of(foyer));
        assertEquals(foyer.getIdFoyer(), foyerService.retrieveFoyer(foyer.getIdFoyer()).getIdFoyer());

    }
    @Test
    void retrieveAllStockTest() {
        when(foyerRepository.findAll()).thenReturn(Stream.of(new Foyer(), new Foyer(), new Foyer()).toList());
        assertEquals(3, foyerService.retrieveAllFoyers().size());
    }


    @Test
    void addFoyerSectorTest() {
        Foyer  foyer  = new Foyer();
        when(foyerRepository.save(foyer)).thenReturn(foyer);
        assertEquals(foyer, foyerService.addFoyer(foyer));
    }
    @Test
    void deleteFoyerTest() {
        Foyer foyer = new Foyer();
        Foyer foyer1 = new Foyer();
        foyerService.removeFoyer(foyer.getIdFoyer()); // Use operator.getId() to get the ID
        foyerService.removeFoyer(foyer1.getIdFoyer()); // Use operator1.getId() to get the ID
        verify(foyerRepository, times(2)).deleteById(foyer.getIdFoyer());
    }
    @Test
    void updateFoyerTest() {
        Foyer foyer = new Foyer();
        when(foyerRepository.save(foyer)).thenReturn(foyer);
        assertEquals(foyer, foyerService.modifyFoyer(foyer));
    }






}