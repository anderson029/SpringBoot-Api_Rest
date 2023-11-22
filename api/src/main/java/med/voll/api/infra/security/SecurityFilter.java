//package med.voll.api.infra.security;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//

//public class SecurityFilter extends OncePerRequestFilter {
//
//    @Override //@Component /* Para o spring carregar a class de uma forma genérica*/
//protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        var tokenJWT = recuperarToken(request);
//
//        System.out.println(tokenJWT);
//
//        filterChain.doFilter(request, response);
//        }
//
//private String recuperarToken(HttpServletRequest request) {
//        var authorizationHeader = request.getHeader("Authorization");
//        if (authorizationHeader == null) {
//        throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization!");`
//        }
//
//        return authorizationHeader.replace("Bearer ", "");
//        }
//}
