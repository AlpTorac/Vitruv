package tools.vitruv.framework.oinfo.vsum;

import tools.vitruv.change.interaction.InternalUserInteractor;
import tools.vitruv.change.oinfo.oisi.OISIRegister;
import tools.vitruv.change.propagation.ChangePropagationSpecificationProvider;
import tools.vitruv.framework.views.ViewTypeRepository;
import tools.vitruv.framework.vsum.helper.VsumFileSystemLayout;
import tools.vitruv.framework.vsum.internal.VirtualModelImpl;

public class OrthogonalInformationIntegratingVirtualModelImpl extends VirtualModelImpl
        implements OrthogonalInformationIntegratingInternalVirtualModel {
    private final OISIRegister oisiRegister;

    public OrthogonalInformationIntegratingVirtualModelImpl(VsumFileSystemLayout fileSystemLayout,
            InternalUserInteractor userInteractor, ViewTypeRepository viewTypeRepository,
            ChangePropagationSpecificationProvider changePropagationSpecificationProvider, OISIRegister oisiRegister) {
        super(fileSystemLayout, userInteractor, viewTypeRepository, changePropagationSpecificationProvider);
        this.oisiRegister = oisiRegister;
    }
}
