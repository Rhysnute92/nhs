/* package uk.ac.cf.spring.nhs.Dashboard.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DashboardController.class)
public class DashboardControllerTest {

        @Autowired
        private WebApplicationContext context;
    
        @Autowired
        private FilterChainProxy springSecurityFilterChain;
    
        @Autowired
        private MockMvc mockMvc;
    
        @Before
        public void setup() {
            this.mockMvc = webAppContextSetup(context)
            .apply(springSecurity(springSecurityFilterChain))
            .build();
        }

    @Test
    @WithMockUser(username="admin",roles={"PATIENT","ADMIN"})
    public void testDashboardForMobile() throws Exception {
        mockMvc.perform(get("/dashboard")
                .header("User-Agent",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1"))
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard/mobile/dashboard"));
    }

    @Test
    @WithMockUser(username="admin",roles={"PATIENT","ADMIN"})
    public void testDashboardForDesktop() throws Exception {
        mockMvc.perform(get("/dashboard")
                .header("User-Agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"))
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard/desktop/dashboard"));
    }

    @Test
    @WithMockUser(username="admin",roles={"PATIENT","ADMIN"})
    public void testDashboardForNoUserAgent() throws Exception {
        mockMvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard/desktop/dashboard"));
    }
}
 */