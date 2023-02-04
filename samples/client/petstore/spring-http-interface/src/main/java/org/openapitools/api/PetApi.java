/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.4.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ApiResponseDto;
import org.openapitools.model.PetDto;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface PetApi {

    /**
     * POST /pet : Add a new pet to the store
     *
     * @param body Pet object that needs to be added to the store (required)
     * @return successful operation (status code 200)
     *         or Invalid input (status code 405)
     */
    @HttpExchange(
        method = "POST",
        value = "/pet",
        accept = "application/json",
        contentType = "application/json"
    )
    ResponseEntity<Void> addPet(
         @RequestBody PetDto body
    );


    /**
     * DELETE /pet/{petId} : Deletes a pet
     *
     * @param petId Pet id to delete (required)
     * @param apiKey  (optional)
     * @return successful operation (status code 200)
     *         or Invalid pet value (status code 400)
     */
    @HttpExchange(
        method = "DELETE",
        value = "/pet/{petId}",
        accept = "application/json"
    )
    ResponseEntity<Void> deletePet(
         @PathVariable("petId") Long petId,
         @RequestHeader(value = "api_key", required = false) String apiKey
    );


    /**
     * GET /pet/findByStatus : Finds Pets by status
     * Multiple status values can be provided with comma separated strings
     *
     * @param status Status values that need to be considered for filter (required)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     */
    @HttpExchange(
        method = "GET",
        value = "/pet/findByStatus",
        accept = "application/json"
    )
    ResponseEntity<List<PetDto>> findPetsByStatus(
         @RequestParam(value = "status", required = true) List<String> status
    );


    /**
     * GET /pet/findByTags : Finds Pets by tags
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param tags Tags to filter by (required)
     * @return successful operation (status code 200)
     *         or Invalid tag value (status code 400)
     * @deprecated
     */
    @Deprecated
    @HttpExchange(
        method = "GET",
        value = "/pet/findByTags",
        accept = "application/json"
    )
    ResponseEntity<Set<PetDto>> findPetsByTags(
         @RequestParam(value = "tags", required = true) Set<String> tags
    );


    /**
     * GET /pet/{petId} : Find pet by ID
     * Returns a single pet
     *
     * @param petId ID of pet to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Pet not found (status code 404)
     */
    @HttpExchange(
        method = "GET",
        value = "/pet/{petId}",
        accept = "application/json"
    )
    ResponseEntity<PetDto> getPetById(
         @PathVariable("petId") Long petId
    );


    /**
     * PUT /pet : Update an existing pet
     *
     * @param body Pet object that needs to be added to the store (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Pet not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @HttpExchange(
        method = "PUT",
        value = "/pet",
        accept = "application/json",
        contentType = "application/json"
    )
    ResponseEntity<Void> updatePet(
         @RequestBody PetDto body
    );


    /**
     * POST /pet/{petId} : Updates a pet in the store with form data
     *
     * @param petId ID of pet that needs to be updated (required)
     * @param name Updated name of the pet (optional)
     * @param status Updated status of the pet (optional)
     * @return Invalid input (status code 405)
     */
    @HttpExchange(
        method = "POST",
        value = "/pet/{petId}",
        accept = "application/json",
        contentType = "application/x-www-form-urlencoded"
    )
    ResponseEntity<Void> updatePetWithForm(
         @PathVariable("petId") Long petId,
         @RequestParam(value = "name", required = false) String name,
         @RequestParam(value = "status", required = false) String status
    );


    /**
     * POST /pet/{petId}/uploadImage : uploads an image
     *
     * @param petId ID of pet to update (required)
     * @param additionalMetadata Additional data to pass to server (optional)
     * @param file file to upload (optional)
     * @return successful operation (status code 200)
     */
    @HttpExchange(
        method = "POST",
        value = "/pet/{petId}/uploadImage",
        accept = "application/json",
        contentType = "multipart/form-data"
    )
    ResponseEntity<ApiResponseDto> uploadFile(
         @PathVariable("petId") Long petId,
         @RequestParam(value = "additionalMetadata", required = false) String additionalMetadata,
         @RequestPart(value = "file", required = false) MultipartFile file
    );


    /**
     * POST /fake/{petId}/uploadImageWithRequiredFile : uploads an image (required)
     *
     * @param petId ID of pet to update (required)
     * @param requiredFile file to upload (required)
     * @param additionalMetadata Additional data to pass to server (optional)
     * @return successful operation (status code 200)
     */
    @HttpExchange(
        method = "POST",
        value = "/fake/{petId}/uploadImageWithRequiredFile",
        accept = "application/json",
        contentType = "multipart/form-data"
    )
    ResponseEntity<ApiResponseDto> uploadFileWithRequiredFile(
         @PathVariable("petId") Long petId,
         @RequestPart(value = "requiredFile", required = true) MultipartFile requiredFile,
         @RequestParam(value = "additionalMetadata", required = false) String additionalMetadata
    );

}
