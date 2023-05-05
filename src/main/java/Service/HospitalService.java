package Service;

import DAO_LAYERS.HospitalDAO;
import DTO_LAYERS.HospitalDTO;
import DTO_LAYERS.UserDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class HospitalService {
    private final HospitalDAO hospital = HospitalDAO.getInstance();
    private final static HospitalService INSTANCE = new HospitalService();


    public List<HospitalDTO> findAll() throws SQLException {
        return hospital.selectAllHospitals().stream().map(
                flight -> new HospitalDTO(
                        flight.getId_hospital(),
                        """
                           %s - %s - %s
                        """.formatted(
                                flight.getName_hospital(),
                                flight.getSpecialisation(),
                                flight.getId_hospital()
                        )
                )
        ).collect(Collectors.toList());
    }
    private HospitalService () {}
    public static HospitalService getInstance() {return INSTANCE;}
}
