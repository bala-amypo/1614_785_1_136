// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.FinancialProfile;

// public interface FinancialProfileService{
//     FinancialProfile postData3(FinancialProfile use);
//     List<FinancialProfile>getAllData3();
//     String  DeleteData3(Long id);
//     FinancialProfile getData3(Long id);         
//     FinancialProfile updateData3(Long id,FinancialProfile entity);                                                        
// }





// package com.example.demo.service;

// import com.example.demo.entity.FinancialProfile;

// public interface FinancialProfileService {
//     FinancialProfile createOrUpdate(FinancialProfile profile);
// }












// package com.example.demo.service;

// import com.example.demo.entity.FinancialProfile;
// import java.util.List;

// public interface FinancialProfileService {

//     FinancialProfile postData3(FinancialProfile profile);

//     List<FinancialProfile> getAllData3();

//     String DeleteData3(Long id);

//     FinancialProfile getData3(Long id);

//     FinancialProfile updateData3(Long id, FinancialProfile entity);
// }













// public interface FinancialProfileService {

//     FinancialProfile createOrUpdateProfile(FinancialProfile profile);

//     FinancialProfile getProfileByUserId(Long userId);
// }








// // src/main/java/com/example/demo/service/FinancialProfileService.java
// package com.example.demo.service;

// import com.example.demo.entity.FinancialProfile;

// public interface FinancialProfileService {
//     FinancialProfile createOrUpdate(FinancialProfile profile);
//     FinancialProfile getByUserId(Long userId);
// }










// src/main/java/com/example/demo/service/FinancialProfileService.java
package com.example.demo.service;

import com.example.demo.entity.FinancialProfile;

public interface FinancialProfileService {
    FinancialProfile createOrUpdate(FinancialProfile profile);
    FinancialProfile getByUserId(Long userId);
}