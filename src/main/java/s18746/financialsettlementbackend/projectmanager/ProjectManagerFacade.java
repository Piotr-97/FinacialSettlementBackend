package s18746.financialsettlementbackend.projectmanager;

import lombok.AllArgsConstructor;
import s18746.financialsettlementbackend.projectmanager.dtos.*;
import s18746.financialsettlementbackend.projectmanager.entities.Address;
import s18746.financialsettlementbackend.projectmanager.entities.Client;
import s18746.financialsettlementbackend.projectmanager.entities.WorkUnderProject;
import s18746.financialsettlementbackend.projectmanager.exceptions.AddressNotFoundException;
import s18746.financialsettlementbackend.projectmanager.exceptions.ClientNotFoundException;
import s18746.financialsettlementbackend.projectmanager.exceptions.ProjectNotFoundException;
import s18746.financialsettlementbackend.projectmanager.entities.Project;
import s18746.financialsettlementbackend.projectmanager.repositories.AddressRepository;
import s18746.financialsettlementbackend.projectmanager.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class ProjectManagerFacade {

    private final WorkUnderProjectFacade workUnderProjectFacade;
    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public ProjectDto getProjectByProjectDto(ProjectDto projectDto) throws Exception {
        Optional<Project> project = projectRepository.findById(projectDto.id());
        if (project.isPresent()) {
        }
        throw new Exception("aaa");
    }

    public Project getProjectByUuid(String uuid) throws ProjectNotFoundException {

        Optional<Project> project = projectRepository.findProjectByUuid(uuid);
        if (project.isPresent()) {
            return project.get();
        }
        throw new ProjectNotFoundException("Project not found");
    }


    public void addProject(ProjectRequest projectRequest) {
        Optional<Client> clientByUuid = clientRepository.findClientByUuid(projectRequest.clientUuid());
        if (clientByUuid.isPresent()) {
            Project project = Project.builder()
                    .client(clientByUuid.get())
                    .workUnderProject(Collections.emptySet())
                    .name(projectRequest.name())
                    .build();
            projectRepository.save(project);
        }
        throw new ClientNotFoundException("Client not found");
    }


    public Project updateProject(ProjectDto updateProject) {
        Optional<Project> oldproject = projectRepository.findById(updateProject.id());
        if (oldproject.isPresent()) {
            Project changedProject = oldproject.get();
            if (!changedProject.getName().equals(updateProject.projectName())) {
                changedProject.setName(updateProject.projectName());
            }
            return projectRepository.save(changedProject);
        }
        return null;
    }

    public List<ClientResponse> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> clientsResponse = new ArrayList<>();
        clients.forEach(x -> clientsResponse.add(
                new ClientResponse(x.getUuid(), x.getName(), x.getNip(), x.getAddress().getStreet())));
        return clientsResponse;
    }

    public void addClient(ClientRequest clientRequest) {
        Optional<Address> addressByUuid = addressRepository.findAddressByUuid(clientRequest.addressUuid());
        if (addressByUuid.isPresent()) {
            Client client = Client.builder()
                    .name(clientRequest.name())
                    .nip(clientRequest.nip())
                    .address(addressByUuid.get())
                    .build();
            clientRepository.save(client);
            return;
        }
        throw new AddressNotFoundException("Address not found");
    }

    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectResponse> list = new ArrayList<>();
        List<WorkUnderProjectResponse> workUnderProjects;
        for (Project x :
                projects) {
            workUnderProjects = new ArrayList<>();
            for (WorkUnderProject w:
                 x.getWorkUnderProject()) {
                workUnderProjects.add(new WorkUnderProjectResponse(w.getUuid(),w.getName(), x.getUuid(), w.getDescription()));
            }

            list.add(new ProjectResponse(x.getName(),x.getClient().getName(),x.getUuid(),workUnderProjects));
        }


//        projects.forEach(x -> list.add(new ProjectResponse(x.getName(),x.getClient().getName(),x.getUuid())));

        return list;
    }
}
