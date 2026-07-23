package ec.edu.uce.application.interceptor;

import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor
public class AuditoriaInterceptor2 {

    private static int create = 0;
    private static int read = 0;
    private static int update = 0;
    private static int delete = 0;

    public Object intercept(InvocationContext context) throws Exception {
        String metodo = context.getMethod().getName();
        System.out.println("Método ejecutado: " + metodo);
        contarOperacion(metodo);
        return context.proceed();
    }

    private void contarOperacion(String metodo) {
        String met = metodo.toLowerCase();
        if (met.contains("persist") || met.contains("save") || met.contains("crear")) {
            create++;
        } else if (met.contains("find") || met.contains("get") || met.contains("buscar") || met.contains("list")) {
            read++;
        } else if (met.contains("update") || met.contains("merge") || met.contains("editar")) {
            update++;
        } else if (met.contains("delete") || met.contains("remove") || met.contains("eliminar")) {
            delete++;
        }
    }

    public static void mostrarConteo() {
        System.out.println("Placa - INSERTADO: " + create + " SELECCIONADO: " + read + " ACTUALIZADO: " + update + " ELIMINADO: " + delete);
    }
}
