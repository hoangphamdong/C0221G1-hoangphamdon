package com.example.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Integer contractDetailId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "attach_service_id",referencedColumnName = "attach_service_id")
    private AttachService attachService;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contract_id",referencedColumnName = "contract_id")
    private Contract contract;

    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail(Integer contractDetailId, AttachService attachService, Contract contract, Integer quantity) {
        this.contractDetailId = contractDetailId;
        this.attachService = attachService;
        this.contract = contract;
        this.quantity = quantity;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
