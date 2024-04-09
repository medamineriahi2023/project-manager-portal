package fr.esprit.projectmanagerportal.clients;

import fr.esprit.projectmanagerportal.external.UserHrInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "self-service-portal")
public interface SelfServiceClient {

    @GetMapping("/self-service/userhrinfo/{userId}")
    UserHrInfo getUserInfoByUserId(@PathVariable("userId") String userId);

    @GetMapping("/self-service/getUsersHrInfoInIds")
    List<UserHrInfo> getUsersInfoByUsersIdsBulk(@RequestParam List<String> usersIds);
}
