package reto3.bbdd.gestores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Factura;

public class GestorFicheros {

	public File writeFile(Factura factura) {
		File file = null;
		FileWriter fileWriter = null;
		BufferedWriter bwriter = null;

		try {
			file = new File("Factura_" + DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss").format(LocalDateTime.now())
					.replace("-", "").replace(":", ""));
			fileWriter = new FileWriter(file, true);
			bwriter = new BufferedWriter(fileWriter);
			DatosCliente(factura, bwriter);
			for (int i = 0; i < factura.getEntradas().size(); i++) {
				if (null != (factura.getEntradas().get(i))) {
					Entrada entrada = factura.getEntradas().get(i);
					DatosEntrada(entrada, bwriter);

				}

			}
			DatosFactura(factura, bwriter);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bwriter != null)

					bwriter.flush();
			} catch (IOException e) {

			}
		}
		try {
			if (bwriter != null)

				bwriter.close();
		} catch (IOException e) {

		}
		try {
			if (bwriter != null) {
				fileWriter.close();

			}
		} catch (IOException e) {

		}
		return file;
	}

	public void DatosCliente(Factura factura, BufferedWriter bwriter) throws IOException {

		String line = "---------------------------------------------------------------------------------";
		String pCliente = factura.getCliente().getNombre() + "\n" + factura.getCliente().getApellido1() + ""
				+ factura.getCliente().getApellido2() + "\n" + factura.getCliente().getEmail() + "\n"
				+ factura.getCliente().getTele();
		String line2 = "----------------------------------------------------------------------------------";
		String cabezera = "Pelicula                              | Cantidad   |  PrecioUnidad | Total   ";

		;

		bwriter.write(line + "\n");
		bwriter.write(pCliente + "\n");
		bwriter.write(line2 + "\n");
		bwriter.write(cabezera + "\n");

	}

	public void DatosEntrada(Entrada entrada, BufferedWriter bwriter) throws IOException {
		String titulo = entrada.getProyeccion().getPelicula().getTitulo();
		String cantidad = entrada.getCantidad() + "";
		String precioUnidad = entrada.getProyeccion().getPrecio() + "";
		String precioTotal = entrada.getPrecio() + "";
		String Line2 = "----------------------------------------------------------------------------------";
		String conte = titulo + "                                |" + cantidad + "    |" + precioUnidad + "      |"
				+ precioTotal;

		bwriter.write(Line2 + "\n");
		bwriter.write(conte + "\n");

	}

	public void DatosFactura(Factura factura, BufferedWriter bwriter) throws IOException {

		String line = "\n\n----------------------------------------------------------------------------------";
		String line2 = "                                                          Descuento:"
				+ (factura.getDescuento() * 100) + "%";
		String Line3 = "                                                       Total    :" + factura.getPrecioTotal();
		bwriter.write(line + "\n");
		bwriter.write(line2 + "\n");
		bwriter.write(Line3 + "\n");
	}
}
