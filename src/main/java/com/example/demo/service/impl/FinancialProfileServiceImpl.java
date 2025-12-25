// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.repository.FinancialProfileRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.FinancialProfileService;                

// @Service
// public class FinancialProfileServiceImpl implements FinancialProfileService{

//     @Autowired FinancialProfileRepository used;
//     @Override
//     public FinancialProfile postData3(FinancialProfile use){
//         return used.save(use);  
//     }
//     @Override
//     public List<FinancialProfile>getAllData3(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData3(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public FinancialProfile getData3(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public FinancialProfile updateData3(Long id,FinancialProfile entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }



// package com.example.demo.service.impl;

//  import java.util.List;
//  import org.springframework.beans.factory.annotation.Autowired;
//  import org.springframework.stereotype.Service;   
//  import com.example.demo.entity.FinancialProfile;
//  import com.example.demo.repository.FinancialProfileRepository;
//  import org.springframework.web.bind.annotation.PathVariable;
//  import com.example.demo.service.FinancialProfileService;                

//  @Service

// public class FinancialProfileServiceImpl {

//     private final FinancialProfileRepository repo;
//     private final UserRepository userRepo;

//     public FinancialProfileServiceImpl(FinancialProfileRepository r, UserRepository u) {
//         repo = r; userRepo = u;
//     }

//     public FinancialProfile createOrUpdate(FinancialProfile fp) {
//         if (fp.getCreditScore() < 300 || fp.getCreditScore() > 900)
//             throw new BadRequestException("creditScore");

//         Long uid = fp.getUser().getId();
//         userRepo.findById(uid)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));

//         Optional<FinancialProfile> existing = repo.findByUserId(uid);
//         if (existing.isPresent()) {
//             fp.setId(existing.get().getId());
//         }
//         return repo.save(fp);
//     }

//     public FinancialProfile getByUserId(Long uid) {
//         return repo.findByUserId(uid)
//                 .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));
//     }
// }




// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.UserRepository;

// import java.util.Optional;

// public class FinancialProfileServiceImpl {

//     private final FinancialProfileRepository repository;
//     private final UserRepository userRepository;

//     public FinancialProfileServiceImpl(FinancialProfileRepository repository,
//                                        UserRepository userRepository) {
//         this.repository = repository;
//         this.userRepository = userRepository;
//     }

//     public FinancialProfile createOrUpdate(FinancialProfile profile) {

//         if (profile.getCreditScore() < 300 || profile.getCreditScore() > 900) {
//             throw new BadRequestException("creditScore");
//         }

//         Long userId = profile.getUser().getId();

//         User user = userRepository.findById(userId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("User not found"));

//         Optional<FinancialProfile> existing =
//                 repository.findByUserId(userId);

//         if (existing.isPresent()) {
//             profile.setId(existing.get().getId());
//         }

//         profile.setUser(user);
//         return repository.save(profile);
//     }

//     public FinancialProfile getByUserId(Long userId) {
//         return repository.findByUserId(userId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Financial profile not found"));
//     }
// }





// package com.example.demo.service.impl;

// import com.example.demo.entity.FinancialProfile;
// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.FinancialProfileRepository;
// import com.example.demo.repository.UserRepository;

// import java.util.Optional;

// public class FinancialProfileServiceImpl {

//     private final FinancialProfileRepository repository;
//     private final UserRepository userRepository;

//     public FinancialProfileServiceImpl(FinancialProfileRepository repository,
//                                        UserRepository userRepository) {
//         this.repository = repository;
//         this.userRepository = userRepository;
//     }

//     public FinancialProfile createOrUpdate(FinancialProfile profile) {

//         if (profile.getCreditScore() == null ||
//             profile.getCreditScore() < 300 ||
//             profile.getCreditScore() > 900) {
//             throw new BadRequestException("Invalid credit score");
//         }

//         if (profile.getUser() == null || profile.getUser().getId() == null) {
//             throw new BadRequestException("User is required");
//         }

//         Long userId = profile.getUser().getId();

//         User user = userRepository.findById(userId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("User not found"));

//         Optional<FinancialProfile> existing =
//                 repository.findByUserId(userId);

//         if (existing.isPresent()) {
//             profile.setId(existing.get().getId());
//         }

//         profile.setUser(user);
//         return repository.save(profile);
//     }

//     public FinancialProfile getByUserId(Long userId) {
//         return repository.findByUserId(userId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Financial profile not found"));
//     }
// }









package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.FinancialProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancialProfileServiceImpl {

    private final FinancialProfileRepository profileRepo;

    public FinancialProfileServiceImpl(FinancialProfileRepository profileRepo) {
        this.profileRepo = profileRepo;
    }

    public FinancialProfile getProfile(Long id) {
        FinancialProfile profile = profileRepo.findById(id)
                .orElseThrow(() -> new BadRequestException("Profile not found"));

        // Null-safe creditScore check
        if (profile.getCreditScore() == null || profile.getCreditScore() < 300) {
            throw new BadRequestException("Credit score invalid");
        }

        return profile;
    }
}
