package tools.vitruv.framework.oinfo.vsum;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

import tools.vitruv.change.interaction.InteractionResultProvider;
import tools.vitruv.change.interaction.InternalUserInteractor;
import tools.vitruv.change.oinfo.oisi.OISIRegister;
import tools.vitruv.change.oinfo.oisi.OrthogonalInformationSourceInterface;
import tools.vitruv.change.oinfo.propagation.OrthogonalInformationIntegratingChangePropagationSpecification;
import tools.vitruv.change.propagation.ChangePropagationSpecification;
import tools.vitruv.change.propagation.ChangePropagationSpecificationProvider;
import tools.vitruv.framework.views.ViewType;
import tools.vitruv.framework.views.ViewTypeRepository;
import tools.vitruv.framework.vsum.VirtualModelBuilder;
import tools.vitruv.framework.vsum.helper.VsumFileSystemLayout;

public class OrthogonalInformationIntegratingVirtualModelBuilder extends VirtualModelBuilder {
    private OISIRegister oisiRegister;

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withChangePropagationSpecification(
            ChangePropagationSpecification changePropagationSpecification) {
        if (this.oisiRegister != null && changePropagationSpecification instanceof OrthogonalInformationIntegratingChangePropagationSpecification castedCPS) {
            castedCPS.setOISIRegister(oisiRegister);
        }
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withChangePropagationSpecification(
                changePropagationSpecification);
    }

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withChangePropagationSpecifications(
            Iterable<ChangePropagationSpecification> changePropagationSpecifications) {
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withChangePropagationSpecifications(
                changePropagationSpecifications);
    }

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withChangePropagationSpecifications(
            ChangePropagationSpecification... changePropagationSpecifications) {
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withChangePropagationSpecifications(
                changePropagationSpecifications);
    }

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withStorageFolder(Path folder) {
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withStorageFolder(folder);
    }

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withStorageFolder(File folder) {
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withStorageFolder(folder);
    }

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withUserInteractor(
            InternalUserInteractor userInteractor) {
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withUserInteractor(userInteractor);
    }

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withUserInteractorForResultProvider(
            InteractionResultProvider resultProvider) {
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withUserInteractorForResultProvider(
                resultProvider);
    }

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withViewType(ViewType<?> viewType) {
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withViewType(viewType);
    }

    @Override
    public OrthogonalInformationIntegratingVirtualModelBuilder withViewTypes(Collection<ViewType<?>> viewTypes) {
        return (OrthogonalInformationIntegratingVirtualModelBuilder) super.withViewTypes(viewTypes);
    }

    public OrthogonalInformationIntegratingVirtualModelBuilder withOISIRegister(OISIRegister oisiRegister) {
        this.oisiRegister = oisiRegister;
        return this;
    }

    public OrthogonalInformationIntegratingVirtualModelBuilder withDefaultOISIRegister() {
        return withOISIRegister(new OISIRegister());
    }

    public OrthogonalInformationIntegratingVirtualModelBuilder withOISI(OrthogonalInformationSourceInterface oisi) {
        this.oisiRegister.addOISI(oisi);
        return this;
    }

    @Override
    public OrthogonalInformationIntegratingInternalVirtualModel buildAndInitialize() throws IOException {
        return (OrthogonalInformationIntegratingInternalVirtualModel) super.buildAndInitialize();
    }

    @Override
    protected OrthogonalInformationIntegratingInternalVirtualModel createVirtualModelInstance(
            VsumFileSystemLayout fileSystemLayout,
            InternalUserInteractor userInteractor, ViewTypeRepository viewTypeRepository,
            ChangePropagationSpecificationProvider changePropagationSpecificationProvider) {
        return new OrthogonalInformationIntegratingVirtualModelImpl(fileSystemLayout, userInteractor,
                viewTypeRepository,
                changePropagationSpecificationProvider, oisiRegister);
    }
}
