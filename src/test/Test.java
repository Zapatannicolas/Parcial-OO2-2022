package test;

import java.time.LocalDate;

import negocio.MateriaABM;
import negocio.NotaPedidoABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1_ "+MateriaABM.getInstance().traerMateria(1));
		
		System.out.println("\n2_"+NotaPedidoABM.getInstance().traerNotaPedidoConMateria(1));
		
		System.out.println("\n3_ "+NotaPedidoABM.getInstance().traer(LocalDate.of(2022, 03, 01)));
		
		System.out.println("\n4_ "+ NotaPedidoABM.getInstance().traerFinales(LocalDate.of(2022, 05, 10), LocalDate.of(2022, 05, 11)));
		
		System.out.println("\n5_ "+ NotaPedidoABM.getInstance().traerFinales(LocalDate.of(2022, 05, 10), LocalDate.of(2022, 05, 11),MateriaABM.getInstance().traerMateria(3)));
		
		System.out.println("\n6_ "+NotaPedidoABM.getInstance().agregar(LocalDate.of(2022, 06, 15), 100, MateriaABM.getInstance().traerMateria(3), "101"));
		
		
	}

}
