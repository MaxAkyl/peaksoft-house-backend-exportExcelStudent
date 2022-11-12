package peaksofthousebackend.apis;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksofthousebackend.services.AdminService;

@RestController
@RequestMapping ("/api/authentication")
@CrossOrigin
public class AdminApi {

    private final AdminService adminService;


    public AdminApi(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/save")
    @PreAuthorize("PermitAll()")
    public SaveAdminResponse save (@RequestBody SaveAdminRequest saveAdminRequest){
        return adminService.save(saveAdminRequest);
    }
}
