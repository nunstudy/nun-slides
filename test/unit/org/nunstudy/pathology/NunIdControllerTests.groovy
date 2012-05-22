package org.nunstudy.pathology



import org.junit.*
import grails.test.mixin.*

@TestFor(NunIdController)
@Mock(NunId)
class NunIdControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/nunId/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.nunIdInstanceList.size() == 0
        assert model.nunIdInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.nunIdInstance != null
    }

    void testSave() {
        controller.save()

        assert model.nunIdInstance != null
        assert view == '/nunId/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/nunId/show/1'
        assert controller.flash.message != null
        assert NunId.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/nunId/list'


        populateValidParams(params)
        def nunId = new NunId(params)

        assert nunId.save() != null

        params.id = nunId.id

        def model = controller.show()

        assert model.nunIdInstance == nunId
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/nunId/list'


        populateValidParams(params)
        def nunId = new NunId(params)

        assert nunId.save() != null

        params.id = nunId.id

        def model = controller.edit()

        assert model.nunIdInstance == nunId
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/nunId/list'

        response.reset()


        populateValidParams(params)
        def nunId = new NunId(params)

        assert nunId.save() != null

        // test invalid parameters in update
        params.id = nunId.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/nunId/edit"
        assert model.nunIdInstance != null

        nunId.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/nunId/show/$nunId.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        nunId.clearErrors()

        populateValidParams(params)
        params.id = nunId.id
        params.version = -1
        controller.update()

        assert view == "/nunId/edit"
        assert model.nunIdInstance != null
        assert model.nunIdInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/nunId/list'

        response.reset()

        populateValidParams(params)
        def nunId = new NunId(params)

        assert nunId.save() != null
        assert NunId.count() == 1

        params.id = nunId.id

        controller.delete()

        assert NunId.count() == 0
        assert NunId.get(nunId.id) == null
        assert response.redirectedUrl == '/nunId/list'
    }
}
