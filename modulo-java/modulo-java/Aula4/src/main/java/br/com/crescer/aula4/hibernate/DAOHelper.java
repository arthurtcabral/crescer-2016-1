package br.com.crescer.aula4.hibernate;

import br.com.crescer.aula4.entity.Cidade;
import br.com.crescer.aula4.entity.Cliente;
import br.com.crescer.aula4.entity.Material;
import br.com.crescer.aula4.entity.Pedido;
import br.com.crescer.aula4.entity.PedidoItem;
import br.com.crescer.aula4.entity.Produto;
import br.com.crescer.aula4.entity.ProdutoMaterial;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;

public class DAOHelper extends DAO {

    public void exportToCsv(Class classe) throws IOException {
        List<String> colunas = this.listColumnNames(classe);
        FileWriter writer = new FileWriter("NovoArquivo.csv");
        for (int i = 1; i <= colunas.size(); i++) {
            writer.append(colunas.get(i));
            if (i != colunas.size()) {
                writer.append(",");
            }
        }
        writer.append("\n");

        if (classe.getName().equals("Cidade")) {
            for (Cidade cidade : (List<Cidade>) this.listAll(Cidade.class)) {
                writer.append(cidade.getIdCidade().toString());
                writer.append(",");
                writer.append(cidade.getNome());
                writer.append(",");
                writer.append(cidade.getUf());
                writer.append("\n");
            }
        } else if (classe.getName().equals("Cliente")) {
            for (Cliente cliente : (List<Cliente>) this.listAll(Cliente.class)) {
                writer.append(cliente.getIdCliente().toString());
                writer.append(",");
                writer.append(cliente.getBairro());
                writer.append(",");
                writer.append(cliente.getCep().toString());
                writer.append(",");
                writer.append(cliente.getEndereco());
                writer.append(",");
                writer.append(cliente.getNome());
                writer.append(",");
                writer.append(cliente.getRazaoSocial());
                writer.append(",");
                writer.append(cliente.getSituacao());
                writer.append(",");
                writer.append(cliente.getCidade().getIdCidade().toString());
                writer.append("\n");
            }
        } else if (classe.getName().equals("Material")) {
            for (Material material : (List<Material>) this.listAll(Material.class)) {
                writer.append(material.getIdMaterial().toString());
                writer.append(",");
                writer.append(material.getDescricao());
                writer.append(",");
                writer.append(material.getPesoLiquido().toString());
                writer.append(",");
                writer.append(material.getPrecoCusto().toString());
                writer.append("\n");
            }

        } else if (classe.getName().equals("Pedido")) {
            for (Pedido pedido : (List<Pedido>) this.listAll(Pedido.class)) {
                writer.append(pedido.getIdPedido().toString());
                writer.append(",");
                writer.append(pedido.getDataEntrega().toString());
                writer.append(",");
                writer.append(pedido.getDataPedido().toString());
                writer.append(",");
                writer.append(pedido.getSituacao());
                writer.append(",");
                writer.append(pedido.getValorPedido().toString());
                writer.append(",");
                writer.append(pedido.getCliente().getIdCliente().toString());
                writer.append("\n");
            }
        } else if (classe.getName().equals("PedidoItem")) {
            for (PedidoItem pedidoItem : (List<PedidoItem>) this.listAll(PedidoItem.class)) {
                writer.append(pedidoItem.getIdPedidoItem().toString());
                writer.append(",");
                writer.append(pedidoItem.getPrecoUnitario().toString());
                writer.append(",");
                writer.append(pedidoItem.getQuantidade().toString());
                writer.append(",");
                writer.append(pedidoItem.getSituacao());
                writer.append(",");
                writer.append(pedidoItem.getPedido().getIdPedido().toString());
                writer.append(",");
                writer.append(pedidoItem.getProduto().getIdProduto().toString());
                writer.append("\n");
            }
        } else if (classe.getName().equals("Produto")) {
            for (Produto produto : (List<Produto>) this.listAll(Produto.class)) {
                writer.append(produto.getIdProduto().toString());
                writer.append(",");
                writer.append(produto.getDataCadastro().toString());
                writer.append(",");
                writer.append(produto.getNome());
                writer.append(",");
                writer.append(produto.getPrecoCusto().toString());
                writer.append(",");
                writer.append(produto.getPrecoVenda().toString());
                writer.append(",");
                writer.append(produto.getSituacao());
                writer.append("\n");
            }
        } else if (classe.getName().equals("ProdutoMaterial")) {
            for (ProdutoMaterial produtoMaterial : (List<ProdutoMaterial>) this.listAll(ProdutoMaterial.class)) {
                writer.append(produtoMaterial.getIdProdutoMaterial().toString());
                writer.append(",");
                writer.append(produtoMaterial.getQuantidade().toString());
                writer.append(",");
                writer.append(produtoMaterial.getMaterial().getIdMaterial().toString());
                writer.append(",");
                writer.append(produtoMaterial.getProduto().getIdProduto().toString());
                writer.append("\n");
            }
        }
        writer.flush();
        writer.close();
    }

    private List<String> listColumnNames(Class classe) {
        List<String> listaColunas = new ArrayList<String>();
        Annotation[] annotations = classe.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Column) {
                String nomeColuna = annotation.toString();
                listaColunas.add(nomeColuna);
            }
        }
        return listaColunas;
    }

}
