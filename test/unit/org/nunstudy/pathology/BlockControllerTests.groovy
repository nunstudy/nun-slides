package org.nunstudy.pathology



import org.junit.*
import grails.test.mixin.*

@TestFor(BlockController)
@Mock(Block)
class BlockControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/block/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.blockInstanceList.size() == 0
        assert model.blockInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.blockInstance != null
    }

    void testSave() {
        controller.save()

        assert model.blockInstance != null
        assert view == '/block/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/block/show/1'
        assert controller.flash.message != null
        assert Block.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/block/list'


        populateValidParams(params)
        def block = new Block(params)

        assert block.save() != null

        params.id = block.id

        def model = controller.show()

        assert model.blockInstance == block
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/block/list'


        populateValidParams(params)
        def block = new Block(params)

        assert block.save() != null

        params.id = block.id

        def model = controller.edit()

        assert model.blockInstance == block
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/block/list'

        response.reset()


        populateValidParams(params)
        def block = new Block(params)

        assert block.save() != null

        // test invalid parameters in update
        params.id = block.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/block/edit"
        assert model.blockInstance != null

        block.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/block/show/$block.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        block.clearErrors()

        populateValidParams(params)
        params.id = block.id
        params.version = -1
        controller.update()

        assert view == "/block/edit"
        assert model.blockInstance != null
        assert model.blockInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/block/list'

        response.reset()

        populateValidParams(params)
        def block = new Block(params)

        assert block.save() != null
        assert Block.count() == 1

        params.id = block.id

        controller.delete()

        assert Block.count() == 0
        assert Block.get(block.id) == null
        assert response.redirectedUrl == '/block/list'
    }
}
