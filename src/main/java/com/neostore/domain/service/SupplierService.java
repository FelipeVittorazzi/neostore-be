    package com.neostore.domain.service;

    import com.neostore.domain.exception.CnpjBusinessException;
    import com.neostore.domain.exception.EmailBusinessException;
    import com.neostore.domain.exception.SuplierBusinessException;
    import com.neostore.domain.exception.SuplierNotFoundException;
    import com.neostore.domain.exception.validation.CnpjValidation;
    import com.neostore.domain.exception.validation.EmailValidation;
    import com.neostore.domain.model.Supplier;
    import com.neostore.domain.repositories.SupplierRepository;

    import javax.ws.rs.core.Response;
    import java.util.List;

    public class SupplierService {

        private final SupplierRepository supplierRepository = new SupplierRepository();

        public List<Supplier> getAll(int page, int size) {
            return supplierRepository.GetAll(page, size);
        }

        public Supplier getById(int id) {
                return validateSupplierExists(id);
        }

        public Supplier findByCnpj(String cnpj) {
            validateCnpjFormat(cnpj); 
            Supplier supplier = supplierRepository.findByCnpj(cnpj);
            if (supplier == null) {
                throw new SuplierNotFoundException("Supplier not found with CNPJ: " + cnpj, Response.Status.NOT_FOUND);
            }
            return supplier;
        }
    
        public Supplier findByEmail(String email) {
            validateEmailFormat(email);
            Supplier supplier = supplierRepository.findByEmail(email);
            if (supplier == null) {
                throw new SuplierNotFoundException("Supplier not found with email: " + email, Response.Status.NOT_FOUND);
            }
            return supplier;
        }

        public Supplier post(Supplier supplier) {
            validateSupplier(supplier);
            validateCnpjAndEmail(supplier);
            return supplierRepository.Add(supplier);
        }

        public Supplier put(int id, Supplier supplier) {
            validateSupplierExists(id);
            validateCnpjAndEmail(supplier);
            supplier.setId(id);
            return supplierRepository.Edit(supplier);
        }

        public void delete(int id) {
            validateSupplierExists(id);
            supplierRepository.Delete(id);
        }

        private void validateSupplier(Supplier supplier) {
            if (supplierRepository.findByCnpj(supplier.getCnpj()) != null) {
                throw new SuplierBusinessException(String.format("CNPJ already registered: %s" , supplier.getCnpj()), Response.Status.CONFLICT);
            }
            if (supplierRepository.findByEmail(supplier.getEmail()) != null) {
                throw new SuplierBusinessException(String.format("Email already registered: %s" , supplier.getEmail()), Response.Status.CONFLICT);
            }
        }

        private Supplier validateSupplierExists(int id) {
            Supplier existingSupplier = supplierRepository.Get(id);
            if (existingSupplier == null) {
                throw new SuplierNotFoundException(String.format("Supplier not found with id %d", id), Response.Status.NOT_FOUND);
            }
            return existingSupplier;
        }

        private void validateCnpjAndEmail(Supplier supplier) {
            if (!CnpjValidation.validate(supplier.getCnpj())) {
                throw new CnpjBusinessException("Invalid CNPJ format", Response.Status.BAD_REQUEST);
            }
            if (!EmailValidation.validate(supplier.getEmail())) {
                throw new EmailBusinessException("Invalid email format", Response.Status.BAD_REQUEST);
            }
        }

        private void validateCnpjFormat(String cnpj) {
            if (!CnpjValidation.validate(cnpj)) {
                throw new CnpjBusinessException("Invalid CNPJ format", Response.Status.BAD_REQUEST);
            }
        }
    
        private void validateEmailFormat(String email) {
            if (!EmailValidation.validate(email)) {
                throw new EmailBusinessException("Invalid email format", Response.Status.BAD_REQUEST);
            }
        }
    }